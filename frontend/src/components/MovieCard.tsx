import { movieById } from './ViewAllMovies.tsx';
import axios from "axios";
import {navigate, useNavigate} from "react-router-dom";
import {useState} from "react";
import {Movie} from "../models/movie.tsx";

export default function MovieCard({id}: {id: string}) {
    const [movie, setMovie] = useState<Movie> ()

    function fetchMovie(id: string) {
        axios.get(`/api/movies/${id}`)
            .then(response => {
                setMovie(response.data);
            })
            .catch(error => {
                console.error('Error fetching data:', error);
            });
    }

    useEffect(() => {
        fetchMovie(id);
    }, [id]);

    return (
        <div className="card">
            <div className="card-body">
                <h5 className="card-title">{movie.title}</h5>
                <h6 className="card-subtitle mb-2 text-muted">{movie.author}</h6>
            </div>
        </div>
    );
}

