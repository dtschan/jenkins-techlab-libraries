def call() {
    String result = currentBuild.result?.toLower() ?: 'success'
    node {
        rocketSend avatar: "https://chat.puzzle.ch/emoji-custom/${result}.png", message: "Build ${result} - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)", rawMessage: true
    }       
}
