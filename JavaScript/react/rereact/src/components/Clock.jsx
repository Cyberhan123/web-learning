import * as React from "react";

export default class Clock extends React.Component {
    constructor({props}: { props: any }) {
        super(props);
    }

    render() {
        return (
            <div>
                {this.props}
            </div>
        );
    }

}