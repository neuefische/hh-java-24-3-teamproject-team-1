import {useEffect, useState} from "react";
import axios from 'axios';
import {Movie} from "../models/movie.tsx";
import {Link} from "react-router-dom";

export default function ViewAllMovies() {
    const [movies, setMovies] = useState<Movie[]>([]);


    const fetchData = () => {
        axios.get('/api/movies')
            .then(response => {
                setMovies(response.data);
            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });
    };

    useEffect(() => {
        fetchData();

    }, []);


    return (
        <>
            {movies.map((movie) => (
                <div key={movie.id}>
                    <h2>{movie.title} by {movie.author}</h2>
                    <Link to={`/movies/${movie.id}`}>View Details</Link>
                </div>
            ))}
        </>
    )
}

