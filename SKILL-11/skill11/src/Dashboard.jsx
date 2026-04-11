import { useState } from "react";
import LocalUserList from "./LocalUserList";
import UserList from "./UserList";
import FakePostList from "./FakePostList";

function Dashboard() {
  const [page, setPage] = useState("");

  return (
    <div>
      {/* 🌟 Navbar */}
      <nav className="navbar">
        <h2>News Portal</h2>
        <div>
          <button onClick={() => setPage("local")}>Local Users</button>
          <button onClick={() => setPage("api")}>Users API</button>
          <button onClick={() => setPage("posts")}>Fake API Posts</button>
        </div>
      </nav>

      {/* 📺 Content */}
      <div className="content">
        {page === "" && <h3>Welcome! Click a button to view data 👆</h3>}
        {page === "local" && <LocalUserList />}
        {page === "api" && <UserList />}
        {page === "posts" && <FakePostList />}
      </div>
    </div>
  );
}

export default Dashboard;