import React, { Component } from 'react';

class BeerList extends Component {
    constructor(props){
        super(props);
        this.state = ({
           beers: [],
           isLoading: true
        });
    }
    componentDidMount() {
        this.setState({isLoading: true});

        fetch('http://localhost:8090/good-beers')
            .then(response => response.json())
            .then(data => this.setState({beers: data, isLoading: false}));
    }
    render() {
        const {beers,isLoading} = this.state;
        if(isLoading){
            return <p>Loading ....</p>
        }
        return (
            <div>
                <h2>Beer List</h2>
                {beers.map((beer,i) =>
                    <div key={i+beer.id}>
                        {beer.name}
                    </div>
                )}
            </div>
        );
    }
}

export default BeerList;
