LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)  

LOCAL_LDLIBS := -L$(SYSROOT)/usr/lib -llog
LOCAL_MODULE := native
LOCAL_SRC_FILES := native.cpp

include $(BUILD_SHARED_LIBRARY)