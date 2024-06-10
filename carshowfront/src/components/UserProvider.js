import React, { createContext, useState } from "react";

const UserContext = createContext();

const UserProvider = ({ children }) => {
  const [estaLogeado, setEstaLogeado] = useState(false);

  const login = (nombre) => {
    setEstaLogeado(true);
  };

  const logout = () => {
    setEstaLogeado(false);
  };

  return (
    <UserContext.Provider value={{ estaLogeado, login, logout }}>
      {children}
    </UserContext.Provider>
  );
};

export { UserContext, UserProvider };
