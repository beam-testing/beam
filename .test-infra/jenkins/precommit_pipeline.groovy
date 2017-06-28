#!groovy
import hudson.model.Result

try {
    def compileBuildNum = -1
    stage('Build') {
        compileBuild = build job: 'beam_PreCommit_Build', parameters: [string(name: 'sha1', value: "origin/pr/${ghprbPullId}/head"), string(name: 'prNum', value: "${ghprbPullId}")]
        if(compileBuild.getResult() == Result.SUCCESS.toString()) {
            compileBuildNum = "" + compileBuild.getNumber()
        }
    }
    stage('Test') {
        testBuild = build job: 'beam_PreCommit_Test', parameters: [string(name: 'buildNum', value: compileBuildNum)]
    }
} catch (Exception e) {
    echo e.toString()
}