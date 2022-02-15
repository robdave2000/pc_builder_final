let submitForm = document.getElementById("register-form")

const headers = {
    'Content-Type':'application/json'
}

const handleSubmit = async (e) =>{
    e.preventDefault()
    let bodyObj = {
        username: document.getElementById("registerUsername").value,
        password: document.getElementById("registerPassword").value
    }
    console.log(bodyObj)
    const response = await fetch("http://localhost:8080/api/v1/users/register", {
        method: "POST",
        body: JSON.stringify(bodyObj),
        headers: headers
    })
        .catch(err => console.error(err.message))
    const redirectUrlArr = await response.json()
    if (response.status === 200){
        window.location.replace(redirectUrlArr[0])
    }
}

submitForm.addEventListener("submit", handleSubmit)