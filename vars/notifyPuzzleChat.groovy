def call(String channel = null) {
    echo currentBuild.result
    try {
        String result = currentBuild.result?.toLowerCase() ?: 'success'
    } catch(Exception e) {
        echo e.toString()
    }
    echo result
    node {
        rocketSend(
            channel: channel,
            avatar: "https://chat.puzzle.ch/emoji-custom/${result}.png",
            message: "Build success - ${env.JOB_NAME} ${env.BUILD_NUMBER} (<${env.BUILD_URL}|Open>)",
            rawMessage: true)
    }
}
