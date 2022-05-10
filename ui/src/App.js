import logo from './logo.svg';
import './App.css';
import {Component} from "react";

class App extends Component {
    state = {
        values: [],
        persons: []
    };

    async componentDidMount() {
        let keys = ['First', 'Second', 'Third', 'Fourth'];

        let result = await Promise.all(keys.map(async (k) => {
            const createResponse = await fetch('/dummy/add?' + new URLSearchParams({key: k, value: k + k}).toString());
            const response = await fetch('/dummy/' + k);
            return await response.text();
        }));

        let persons = [{id: 1, login: 'user1', password: 'pass1'}, {id: 2, login: 'user2', password: 'pass2'}];

        let personsResult = await Promise.all(persons.map(async (p) => {
            const createResponse = await fetch('/person/add?' + new URLSearchParams({
                id: p.id,
                login: p.login,
                password: p.password
            }).toString());
            const response = await fetch('/person/' + p.id);
            return await response.json();
        }));

        let messages = ['first', 'second', 'third'];

        messages.forEach(m => {
            fetch('/message/publish?' + new URLSearchParams({message: m}).toString())
        })

        this.setState({values: result, persons: personsResult});
    }

    render() {
        const {values, persons} = this.state;
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <div className="App-intro">
                        <h2>Values</h2>
                        {values.map(v => {
                                return (<div key={v}>
                                    {v}
                                </div>)
                            }
                        )}
                        <h2>Persons</h2>
                        {persons.map(p => {
                                console.log({p})
                                return (<div key={p.id}>
                                    {p.login} {p.password}
                                </div>)
                            }
                        )}
                    </div>
                </header>
            </div>
        );
    }
}

export default App;
