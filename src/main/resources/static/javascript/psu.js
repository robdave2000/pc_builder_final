let productContainer = document.getElementById("product-container")
let searchInput = document.getElementById('search-input')
let searchForm = document.getElementById("search-form")

const  baseUrl = "http://localhost:8080/api/v1/psus"

const getAllProducts = async (url) =>{
    const response = await fetch(`${url}`, {
        method: "GET",
        headers: {'Content-Type': 'application/json'}
    })
        .catch(err => console.error(err.message))

    let responseArr = await response.json();
    console.log(responseArr)

    createProductCards(responseArr);
}

const getProductsBySearch = async (e) =>{
    e.preventDefault()
    const response = await fetch(`${baseUrl}/?search=${searchInput.value}`, {
        method: 'GET',
        headers: 'Content-Type: application/json'
    })
        .catch(err => console.error(err.message))

    let responseArray = await response.json()

    createProductCards(responseArray)
}

const addPsuToPc = async (psuId, pc_Id) =>{
    const response = await fetch(`${baseUrl}/${psuId}/${pc_Id}`, {
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
            <h5 class="card-title" data-product="${obj.id}">${obj.brand} ${obj.level} ${obj.name}</h5>
            <p class="card-text">${obj.price}</p>
            <div>
                <button onclick="addPsuToPc(${obj.id}, pcId)" class="btn btn-primary">Add To Pc</button>
                <a href="https://amazon.com" target="_blank" class="btn btn-warning">Amazon</a>
            </div>
        </div>
        `
        productContainer.append(noteCard);
    })
}

searchForm.addEventListener("submit", getProductsBySearch())

getAllProducts(baseUrl);