#!groovy

PR_SHA = "origin/pr/${ghprbPullId}/head"

try {
    stage('Build') {
        compileBuild = build job: 'beam_PreCommit_Build', parameters: [string(name: 'sha1', value: PR_SHA)]
        echo string(compileBuild.BUILD_NUM)
        echo string(compileBuild)
    }
} catch (Exception e) {
    echo string(e)
}