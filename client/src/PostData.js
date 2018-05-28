export function PostData(type, userData) {

    let BaseURL = 'http://localhost:8090/checkLogin2';
    //console.log(userData.username+" "+userData.password);
    return new Promise((resolve, reject) =>{
        fetch(BaseURL, {
            method: 'POST',
            body: JSON.stringify(userData),
            headers: new Headers({
                'Content-Type': 'application/json',
                'Accept': 'application/json'
              }),
          })
          .then((response) => {
              response.json();
          })
          .then((res) => {
            resolve(res);
          })
          .catch((error) => {
            reject(error);
          });
      });
}