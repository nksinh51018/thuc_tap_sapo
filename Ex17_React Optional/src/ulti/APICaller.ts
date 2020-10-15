import axios from 'axios'
import * as Config from '../constains/Config'

export default async function callAPI(endpoint: string, method:any,body: any,headers: any){
    try {
        return axios({
            method: method,
            url: `${Config.API_URL}/${endpoint}`,
            data: body,
            headers: headers
        })
    }
    catch (e) {
        return console.log(e)
    }

}