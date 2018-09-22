import React, {Component} from 'react';

class PageA extends Component {
    constructor(props) {
        super(props);
        console.log(this.props.match.params.id)
    }

    render() {
        return (
            <div>
                页面A
            </div>
        );
    }
}

export default PageA;