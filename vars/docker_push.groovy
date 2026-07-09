/*def call(String Project, String ImageTag, String dockerhubuser) {
  withCredentials([usernamePassword(credentialsId: 'dockerHubCred', passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
    sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
  }
  sh "docker push ${dockerhubuser}/${Project}: $(ImageTag}"
}
*/



def call(String Project, String ImageTag, String dockerHubUser) {

    withCredentials([
        usernamePassword(
            credentialsId: 'dockerHubCred',
            usernameVariable: 'dockerHubUser',
            passwordVariable: 'dockerHubPass'
        )
    ]) {

        sh "docker login -u ${dockerHubUser} -p ${dockerHubPass}"
    }

    sh "docker push ${dockerHubUser}/${Project}:${ImageTag}"
}
