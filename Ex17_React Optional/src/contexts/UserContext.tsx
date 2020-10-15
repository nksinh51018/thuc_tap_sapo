import React, { createContext, useReducer } from "react";
import user from "../reducers/User";
let localData = localStorage.getItem("USER");
console.log(localData)
export const UserContext = createContext(localData ? JSON.parse(localData) : {});

type Props = {
  children: any;
};

const UserContextProvider = (props: Props) => {
  const [users, dispatch] = useReducer(user, {}, () => {
    let localData = localStorage.getItem("USER");
    return localData ? JSON.parse(localData) : {};
  });

  // useEffect(() => {
  //     localStorage.setItem('USER', JSON.stringify(users))
  // }, [users]);

  return (
    <UserContext.Provider value={{ users, dispatch }}>
      {props.children}
    </UserContext.Provider>
  );
};

export default UserContextProvider;
