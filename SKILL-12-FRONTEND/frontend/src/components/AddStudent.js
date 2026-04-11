import { useState, useEffect } from "react";
import axios from "axios";

function AddStudent({ fetchStudents, editStudent, setEditStudent }) {

  const [student, setStudent] = useState({
    name: "",
    email: "",
    course: ""
  });

  useEffect(() => {
    if (editStudent) {
      setStudent(editStudent);
    }
  }, [editStudent]);

  const handleChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (student.id) {
      await axios.put(`http://localhost:8082/students/${student.id}`, student);
    } else {
      await axios.post("http://localhost:8082/students", student);
    }

    setStudent({ name: "", email: "", course: "" });
    setEditStudent(null);
    fetchStudents();
  };

  return (
    <div className="form-container">
      <h2>{student.id ? "Update Student" : "Add Student"}</h2>

      <form onSubmit={handleSubmit}>
        <input name="name" value={student.name} onChange={handleChange} placeholder="Name" required />
        <input name="email" value={student.email} onChange={handleChange} placeholder="Email" required />
        <input name="course" value={student.course} onChange={handleChange} placeholder="Course" required />
        <button type="submit">Save</button>
      </form>
    </div>
  );
}

export default AddStudent;