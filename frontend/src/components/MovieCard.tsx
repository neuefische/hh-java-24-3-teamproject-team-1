import axios from "axios";
import {useEffect, useState} from "react";
import {useParams} from "react-router-dom";
import {Movie} from "../models/movie.tsx";

export default function MovieCard() {
    const {id} = useParams();
    const [movie, setMovie] = useState({} as Movie);
  async function fetchMovie() {
      try {
          const response = await axios.get(`/api/movies/${id}`);
          setMovie(response.data);
      } catch (error) {
          console.error('Error fetching data:', error);
      }
  }

    useEffect(() => {
        fetchMovie();
    }, [id]);
console.log(movie);
    return (
        <div>
            <h2>Movie Title: {movie.title}</h2>
            <p>Author: {movie.author}</p>
           {/* <p>Genre: {movie.genre}</p>
            <p>Date of publication: {movie.date}</p>*/}
        </div>
    )
}