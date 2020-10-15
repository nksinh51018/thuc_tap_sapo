
var initState = [
    {
        code: "CG_001",
        name: "Mây tre đan",
        description: 'Sản phẩm được làm bằng mây tre đan',
        createdAt: "2020-08-28"
    },
    {
        code: "CG_002",
        name: "Mây tre lá",
        description: 'Sản phẩm được làm bằng mây tre lá',
        createdAt: "2020-08-28"
    },
    {
        code: "CG_003",
        name: "Sản phẩm mây tre lá",
        description: 'Sản phẩm được làm bằng mây tre lá',
        createdAt: "2020-08-28"
    },
    {
        code: "CG_004",
        name: "Mỹ nghệ",
        description: 'Sản phẩm mỹ nghệ',
        createdAt: "2020-08-28"
    },
]

const categoryList = (state = initState, action)=>{
    switch(action.type){
        default:
            return [...state];
    }
}

export default categoryList;