def call(currentBuild, String channel) {
    String result = currentBuild.result?.toLower() ?: 'success'
    node {
        rocketSend(
            channel: channel,
            avatar: "https://chat.puzzle.ch/emoji-custom/${result}.png",
            message: "Build success - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)",
            rawMessage: true)
    }
}
