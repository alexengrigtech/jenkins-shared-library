#!/usr/bin/env groovy

def call() {
    pipeline {
        agent any

        environment {
            GREETING_MESSAGE = 'Hello, Application!'
        }

        stages {
            stage('Greeting') {
                steps {
                    echo "${GREETING_MESSAGE}"
                }
            }
        }
    }
}
