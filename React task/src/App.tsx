import React from "react";
import ShoppingCart from "./ShoppingCart";
import "bootstrap/dist/css/bootstrap.min.css";

const App: React.FC = () => {
  return (
    <div className="container mt-5">
      <h1 className="text-primary">React test application</h1>
      <ShoppingCart />
    </div>
  );
};

export default App;
