import React, { useState, useEffect } from "react";
import axios from "axios";
import CartItem from "./CartItem";

interface Item {
  id: number;
  name: string;
  price: number;
  quantity: number;
}

const ShoppingCart: React.FC = () => {
  const [cartItems, setCartItems] = useState<Item[]>([]);
  const [loading, setLoading] = useState<boolean>(true);
  const [newItem, setNewItem] = useState({ name: "", price: "" });

  useEffect(() => {
    axios
      .get("https://fakestoreapi.com/products?limit=5")
      .then((response) => {
        const fetchedItems = response.data.map((item: any) => ({
          id: item.id,
          name: item.title,
          price: item.price,
          quantity: 1,
        }));
        setCartItems(fetchedItems);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error fetching data:", error);
        setLoading(false);
      });
  }, []);

  const removeItem = (id: number) => {
    setCartItems(cartItems.filter((item) => item.id !== id));
  };

  const handleChange = (e: React.ChangeEvent<HTMLInputElement>) => {
    setNewItem({ ...newItem, [e.target.name]: e.target.value });
  };

  const addItem = (e: React.FormEvent) => {
    e.preventDefault();
    if (newItem.name.trim() && newItem.price.trim()) {
      const newCartItem: Item = {
        id: cartItems.length + 1,
        name: newItem.name,
        price: parseFloat(newItem.price),
        quantity: 1,
      };
      setCartItems([...cartItems, newCartItem]);
      setNewItem({ name: "", price: "" });
    }
  };

  return (
    <div className="container mt-5">
      <h2>Shopping Cart</h2>
      <form onSubmit={addItem} className="mb-4">
        <div className="row">
          <div className="col-md-4">
            <input
              type="text"
              name="name"
              value={newItem.name}
              onChange={handleChange}
              className="form-control"
              placeholder="Enter product name"
            />
          </div>
          <div className="col-md-3">
            <input
              type="number"
              name="price"
              value={newItem.price}
              onChange={handleChange}
              className="form-control"
              placeholder="Enter price"
            />
          </div>
          <div className="col-md-3">
            <button type="submit" className="btn btn-success">
              Add to Cart
            </button>
          </div>
        </div>
      </form>

      {loading ? (
        <p>Loading products...</p>
      ) : cartItems.length === 0 ? (
        <p className="alert alert-warning">Your cart is empty.</p>
      ) : (
        cartItems.map((item) => (
          <CartItem
            key={item.id}
            name={item.name}
            price={item.price}
            quantity={item.quantity}
            onRemove={() => removeItem(item.id)}
          />
        ))
      )}
    </div>
  );
};

export default ShoppingCart;
