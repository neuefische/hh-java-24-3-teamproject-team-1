import './App.css'
import ViewAllMovies from "./components/ViewAllMovies.tsx";
import {Route, Routes} from "react-router-dom";
import MovieCard from "./components/MovieCard.tsx";

function App() {

  return (
    <Routes>
        <Route path="/" element={<ViewAllMovies/>}/>
        <Route path="/movies/:id" element={<MovieCard id={2} />}/>
    </Routes>
  )
}

export default App
