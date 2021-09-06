export default class NavBar extends React.Component {
    // constructor(props) {
    //     super(props)
    // }
    render() {
        return (
            <nav className="navbar navbar-light bg-light">
                <a className="navbar-brand" href="#">
                    <img src="" width="30" height="30" className="d-inline-block align-top" alt="" />
                    Cyberhan
                </a>
                {this.props.children}
            </nav>
        )
    }
}