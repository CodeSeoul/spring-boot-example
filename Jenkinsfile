node {
    stage('Download code') {
        git url: 'https://github.com/LearnTeachCodeSeoul/spring-boot-example'
    }

    stage('Build') {
        if(isUnix()) {
            sh './gradlew clean build'
        } else {
            bat 'gradlew.bat clean build'
        }
    }

    stage('Test') {
        if(isUnix()) {
            sh './gradlew test'
        } else {
            bat 'gradlew.bat test'
        }
    }

    stage('Deploy') {
        if(isUnix()) {
            sh 'java -jar build/libs/springboot-0.0.1.jar'
        } else {
            bat 'start /B java -jar build/libs/springboot-0.0.1.jar'
        }
    }
}
