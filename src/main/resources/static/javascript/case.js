let productContainer = document.getElementById("product-container")
let searchInput = document.getElementById('search-input')
let searchForm = document.getElementById("search-form")
let pcId = window.localStorage.getItem("pc_id")
let headers = {'Content-Type': 'application/json'}

const  baseUrl = "http://localhost:8080/api/v1/cases"

const getAllProducts = async (url) =>{
    const response = await fetch(`${url}`, {
        method: "GET",
        headers: headers
    })
        .catch(err => console.error(err.message))

    let responseArr = await response.json();
    console.log(responseArr)

    createProductCards(responseArr);
}

const getProductsBySearch = async () =>{
    const response = await fetch(`${baseUrl}/?search=${searchInput.value}`, {
        method: 'GET',
        headers: headers
    })
        .catch(err => console.error(err.message))

    let responseArray = await response.json()

    createProductCards(responseArray)
}

const addCaseToPc = async (caseId, pc_Id) =>{
    const response = await fetch(`${baseUrl}/${caseId}/${pc_Id}`, {
        method: 'POST',
        headers: headers
    })
        .catch(err => console.error(err.message))
}

const createProductCards = (arr) =>{
    productContainer.innerHTML = '';
    arr.forEach(obj =>{
        let noteCard = document.createElement("div")
        noteCard.classList.add("card", "d-flex", "flex-column", "justify-content-end", "m-1")
        noteCard.style.width = "18rem"
        noteCard.innerHTML = `
        <div class="card-body d-flex flex-column justify-content-between">
            <img src="https://images.unsplash.com/photo-1618339220157-daa2cd9ade56?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8cGMlMjBjYXNlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60" class="card-img-top" alt="cpu image" style="height: 225px; object-fit: scale-down">
            <h5 class="card-title" data-product="${obj.id}">${obj.brand} ${obj.name}</h5>
            <p class="card-text">${obj.type} ${obj.color}</p>
            <p class="card-text">${obj.price}</p>
            <div>
                <button onclick="addCaseToPc(${obj.id}, pcId)" class="btn btn-primary">Add To Pc</button>
                <a href="https://amazon.com" target="_blank" class="btn btn-warning">Amazon</a>
            </div>
        </div>
        `
        productContainer.append(noteCard);
    })
}

searchForm.addEventListener("submit", (e)=>{
    e.preventDefault();
    getProductsBySearch()
})

getAllProducts(baseUrl);