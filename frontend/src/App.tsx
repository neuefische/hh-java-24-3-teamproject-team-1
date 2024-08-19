import './App.css'
import ViewAllMovies from "./components/ViewAllMovies.tsx";
import NewMovieForm from "./components/NewMovieForm.tsx";
import {Route, Routes} from "react-router-dom";

function App() {



  return (
    <Routes>
        <Route path="/movies" element={<ViewAllMovies/>}/>
        <Route path="/movies/add" element={<NewMovieForm/>}/>
    </Routes>
  )
}

export default App
