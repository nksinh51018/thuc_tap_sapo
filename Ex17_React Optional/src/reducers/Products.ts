
var initState = [
    {
        url: "./image/Products/4.jpg",
        name: "BLACK CREPE FLORAL PRINT",
        price: 350000,
    },
    {
        url: "./image/Products/5.jpg",
        name: "BLACK CREPE FLORAL PRINT",
        price: 350000,
    },
    {
        url: "./image/Products/6.jpg",
        name: "BLACK CREPE FLORAL PRINT",
        price: 350000,
    },
    {
        url: "./image/Products/7.jpg",
        name: "BLACK CREPE FLORAL PRINT",
        price: 350000,
    },
    {
        url: "./image/Products/8.jpg",
        name: "BLACK CREPE FLORAL PRINT",
        price: 350000,
    },
    {
        url: "./image/Products/9.jpg",
        name: "BLACK CREPE FLORAL PRINT",
        price: 350000,
    },
    {
        url: "./image/Products/10.jpg",
        name: "BLACK CREPE FLORAL PRINT",
        price: 350000,
    },
    {
        url: "./image/Products/11.jpg",
        name: "BLACK CREPE FLORAL PRINT",
        price: 350000,
    },
]

const products = (state = initState, action: { type: string; }) => {
    switch (action.type) {
        default:
            return [...state]
    }
}

export default products;