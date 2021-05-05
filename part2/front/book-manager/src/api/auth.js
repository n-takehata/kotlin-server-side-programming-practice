import { client } from './client'

export default {
  login (email, password) {
    var params = new URLSearchParams()
    params.append('email', email)
    params.append('pass', password)

    return client.post('http://localhost:8080/login', params)
  }
}
