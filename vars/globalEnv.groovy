#!/usr/bin/env groovy

import tech.alexengrig.jenkins.sharedlibrary.GlobalEnv

@SuppressWarnings('GrMethodMayBeStatic')
void set(String key, String value) {
    GlobalEnv.createGlobalEnv(key, value)
}
