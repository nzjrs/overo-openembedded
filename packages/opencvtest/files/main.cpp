#include <cv.h>
#include <highgui.h>

#include <ctype.h>
#include <stdio.h>

CvCapture *utils_get_capture(int argc, char** argv)
{
    CvCapture* capture = NULL;
    const char* input_name;

    input_name = argc > 1 ? argv[1] : 0;
    
    if( !input_name || (isdigit(input_name[0]) && input_name[1] == '\0') )
        capture = cvCaptureFromCAM( !input_name ? 0 : input_name[0] - '0' );
    else
        capture = cvCaptureFromAVI( input_name ); 

    return capture;
}

int main( int argc, char** argv )
{
    CvCapture* capture = NULL;
    IplImage *frame = NULL;

    capture = utils_get_capture(argc, argv);

    if( capture )
    {
        cvNamedWindow( "video", CV_WINDOW_AUTOSIZE );

        for(;;)
        {
            frame = cvQueryFrame( capture );
            if( !frame )
                break;

            cvShowImage( "video", frame );

            if( cvWaitKey( 10 ) >= 0 )
                break;
        }
        cvReleaseCapture( &capture );
        cvDestroyWindow("video");
    }
    
    return 0;
}
