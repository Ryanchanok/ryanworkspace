LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_SRC_FILES := $(call all-java-files-under, src)
LOCAL_JAVA_LIBRARIES := ChinatspIncallInterface
#LOCAL_MODULE_TAGS :=optional
LOCAL_PACKAGE_NAME := TVoiceService
LOCAL_CERTIFICATE :=platform
LOCAL_PRIVILEGED_MODULE := false
LOCAL_DEX_PREOPT := false
include $(BUILD_PACKAGE)