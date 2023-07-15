const cTableBody = document.getElementById('ctable_body');
const inputSearch = document.getElementById('search_data');
const searchButton = document.getElementById('sort_mkg_cap');
const percentageButton = document.getElementById('sort_percentage');

let coinDateDetails =[];

fetch('https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=10&page=1&sparkline=false')
.then(response => response.json())
.then(data => {
    coinDateDetails = data.map(item => ({
        logoImage:item.image,
        name : item.name,
        id: item.symbol,
        currentPrice : item.current_price,
        
        percebtageChange: item.market_cap_change_percentage_24h,
        marketCap: item.market_cap
    }));
    renderTable(coinDateDetails);
})
.catch(error => {
    console.error('Error:',error)
});

//fetch data & render

async function fetchData(){
    try{
        const response = await fetch('https://api.coingecko.com/api/v3/coins/markets?vs_currency=usd&order=market_cap_desc&per_page=10&page=1&sparkline=false');

        const data = await response.json();
        coinDateDetails = data.map(item =>({
            logoImage:item.image,
            name : item.name,
            id: item.symbol,
            currentPrice : item.current_price,
           
            percebtageChange: item.market_cap_change_percentage_24h,
             marketCap: item.market_cap
        }));
        renderTable(coinDateDetails);
    }
    catch(error){
        console.error('Error:',error)
    }
    }

    //search functionality
    inputSearch.addEventListener('input', () =>{
 const searchValue =inputSearch.value.toLowerCase();
 const filteredData = coinDateDetails.filter(coin => coin.name.toLowerCase().includes(searchValue));
 renderTable(filteredData);
    })

    //sort on basis of market capital

    searchButton.addEventListener('click',() =>{
        coinDateDetails.sort((a,b)=> b.marketCap - a.marketCap);

        renderTable(coinDateDetails);
    })


    //sort on the basis of percentage change

    percentageButton.addEventListener('click',() =>{
        coinDateDetails.sort((a,b)=>a.percebtageChange - b.percebtageChange);

        renderTable(coinDateDetails);
    })

    //render data to table
function renderTable(data){
    cTableBody.innerHTML='';
data.forEach(item => {
    const row = document.createElement('tr');

    const logoCell = document.createElement('td');
    const logoImage = document.createElement('img');
    //logoImage.style.width="20"
    logoImage.src = item.logoImage;
    logoImage.alt = item.name;
    logoImage.setAttribute("width","20px");
    logoCell.appendChild(logoImage);
    row.appendChild(logoCell);

    
    const nameCell = document.createElement('td');
    nameCell.textContent = item.name;
    row.appendChild(nameCell);

    const idCell = document.createElement('td');
    idCell.textContent = item.id.toLowerCase();
    row.appendChild(idCell);

    const priceCell = document.createElement('td');
    priceCell.textContent = '$'+ item.currentPrice;
    row.appendChild(priceCell);

    const percentageChange24hCell = document.createElement('td');
    percentageChange24hCell.textContent = item.percebtageChange +'%';
if(item.percentageChange24h < 0){
percentageChange24hCell.style.color='red';
}
else {
    percentageChange24hCell.style.color='green';
    }
    row.appendChild(percentageChange24hCell);
    const marketPriceCell = document.createElement('td');
    marketPriceCell.textContent = 'Mkt Cap: $' + item.marketCap;
    row.appendChild(marketPriceCell);

    cTableBody.appendChild(row);
});
    
}

    
