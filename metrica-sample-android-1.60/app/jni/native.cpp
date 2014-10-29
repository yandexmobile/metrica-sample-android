#include <jni.h>
#include <stdio.h>
#include <android/log.h>

#define APPNAME "[Yandex Metrica Sample]"

#define LOGI(...) __android_log_print(ANDROID_LOG_INFO, APPNAME, __VA_ARGS__)

void crashSimulation() {
    LOGI("Simulate native crash");
    volatile int * a = reinterpret_cast<volatile int *> (NULL);
    *a = 1;
}

extern "C" {

    void Java_com_yandex_sample_metrica_Stuff_nativeCrash(JNIEnv* env, jobject obj) {
        crashSimulation();
    }

}
