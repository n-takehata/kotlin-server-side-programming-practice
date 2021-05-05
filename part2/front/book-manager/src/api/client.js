export const client = createClient()

function createClient () {
  const Axios = require('axios')

  return Axios.create({ withCredentials: true })
}
