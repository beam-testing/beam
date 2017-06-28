#!groovy
import hudson.model.Result

// PR_SHA = "origin/pr/${ghprbPullId}/head"

try {
    stage('Build') {
        compileBuild = build job: 'mb-merge-1' // , parameters: [string(name: 'sha1', value: PR_SHA)]
        if(compileBuild.getResult() == Result.SUCCESS.toString()) {
            echo "" + compileBuild.getNumber()
            echo compileBuild.getBuildVariables().get("BUILD_NUM")
        }
    }
} catch (Exception e) {
    echo e.toString()
}