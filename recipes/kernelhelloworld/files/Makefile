obj-m += hello.o

PWD  := $(shell pwd)

default:
	$(MAKE) -C $(KERNELDIR) SUBDIRS=$(PWD) CC=$(CC) modules

clean:
	$(MAKE) -C $(KERNELDIR) SUBDIRS=$(PWD) CC=$(CC) clean
