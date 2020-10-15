import axios from 'axios'
import * as Config from '../constains/Config'

export default function callAPI(endpoint, method = 'GET',body,headers){
    return axios({
        method: method,
        url: `${Config.API_URL}/${endpoint}`,
        data: body,
        headers: headers
    }).catch(e=>console.log(e))

}