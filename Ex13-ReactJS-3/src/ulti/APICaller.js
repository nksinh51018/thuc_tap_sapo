import axios from 'axios'
import * as Config from '../constains/Config'

export default function callAPI(endpoint, method = 'GET',body){
    return axios({
        method: method,
        url: `${Config.API_URL}/${endpoint}`,
        data: body,
    }).catch(e=>console.log(e))

}