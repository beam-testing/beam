#!groovy

// PR_SHA = "origin/pr/${ghprbPullId}/head"

try {
    stage('Build') {
        compileBuild = build job: 'mb-merge-1' // , parameters: [string(name: 'sha1', value: PR_SHA)]
        echo "" + compileBuild.env.BUILD_NUM
        echo compileBuild.env
        echo compileBuild
    }
} catch (Exception e) {
    echo e.toString()
}