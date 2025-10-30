pipeline {
    agent any

    environment {
        // Name of the Maven settings file if you use custom repo config (optional)
        MAVEN_OPTS = "-Dmaven.test.failure.ignore=false"
        // Email to notify
        TEAM_EMAIL = "team@example.com"
    }

    stages {

        stage('Checkout') {
            steps {
                echo "Checking out code from SCM..."
                checkout scm
            }
        }

        stage('Set Up Environment') {
            steps {
                echo "Setting up Maven environment..."
                bat 'mvn -v'
            }
        }

        stage('Clean & Build') {
            steps {
                echo "Cleaning and compiling the project..."
                bat 'mvn clean compile'
            }
        }

        stage('Run Tests') {
            steps {
                echo "Running Selenium + Cucumber Tests..."
                // You can specify tags if needed: mvn test -Dcucumber.filter.tags="@Smoke"
                bat 'mvn test'
            }
        }

        stage('Publish Reports') {
            steps {
                echo "Publishing Cucumber HTML Reports..."
                // You can archive artifacts to keep the report
                archiveArtifacts artifacts: 'target/cucumber-reports/**', fingerprint: true
            }
        }
    }

    post {
        success {
            echo "Build succeeded. Sending notification..."
            mail to: "${TEAM_EMAIL}",
                 subject: "✅ SUCCESS: Build #${BUILD_NUMBER} for ${JOB_NAME}",
                 body: """\
Good news 🎉

The Jenkins build **#${BUILD_NUMBER}** completed successfully.

🔗 Build URL: ${BUILD_URL}
📁 Reports: Check 'target/cucumber-reports' in Jenkins artifacts.

Regards,  
Jenkins CI
"""
        }

        failure {
            echo "Build failed. Sending notification..."
            mail to: "${TEAM_EMAIL}",
                 subject: "❌ FAILED: Build #${BUILD_NUMBER} for ${JOB_NAME}",
                 body: """\
⚠️ The Jenkins build **#${BUILD_NUMBER}** has failed.

🔗 Build URL: ${BUILD_URL}

Please check the console logs and fix the failing tests.

Regards,  
Jenkins CI
"""
        }

        always {
            echo "Cleaning workspace..."
            deleteDir()
        }
    }
}
