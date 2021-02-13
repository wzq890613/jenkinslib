package org.devops


//构建类型
def Build(buildType,buildShell){
    def buildTools = ["mvn":"maven3","npm":"nodejs"]
    
    
    println("当前选择的构建类型为 ${buildType}")
    buildHome= tool buildTools[buildType]
    
    if ("${buildType}" == "npm"){
        
        sh  """ 
            export NODE_HOME=${buildHome} 
            export PATH=\$NODE_HOME/bin:\$PATH 
            ${buildHome}/bin/${buildType} ${buildShell}"""
    } else {
        sh "${buildHome}/bin/${buildType}  ${buildShell}"
    }
}
