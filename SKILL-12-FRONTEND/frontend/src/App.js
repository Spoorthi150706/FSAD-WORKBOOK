import { useState } from "react";
import AddStudent from "./components/AddStudent";
import StudentList from "./components/StudentList";

function App() {

  const [editStudent, setEditStudent] = useState(null);
  const [refresh, setRefresh] = useState(false);

  const fetchStudents = () => {
    setRefresh(!refresh);
  };

  return (
    <div className="app">
      <h1>Student Management System</h1>

      <AddStudent
        fetchStudents={fetchStudents}
        editStudent={editStudent}
        setEditStudent={setEditStudent}
      />

      <StudentList
        setEditStudent={setEditStudent}
        key={refresh}
      />
    </div>
  );
}

export default App;