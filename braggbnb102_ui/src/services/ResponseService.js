import http from "../http-common"; 

class ResponseService {
  getAllResponses(searchDTO) {
    console.log(searchDTO)
    return this.getRequest(`/response/responses`, searchDTO);
  }

  get(responseId) {
    return this.getRequest(`/response/${responseId}`, null);
  }

  findByField(matchData) {
    return this.getRequest(`/response?field=${matchData}`, null);
  }

  addResponse(data) {
    return http.post("/response/addResponse", data);
  }

  update(data) {
  	return http.post("/response/updateResponse", data);
  }
  
  uploadImage(data,responseId) {
  	return http.postForm("/response/uploadImage/"+responseId, data);
  }




	postRequest(url, data) {
		return http.post(url, data);
      };

	getRequest(url, params) {
        return http.get(url, {
        	params: params
        });
    };

}

export default new ResponseService();
