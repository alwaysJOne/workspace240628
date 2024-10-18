import React, { Component } from 'react'
import Comment from './Comment'

const serverComments = [
    {
        id: 1,
        message: "안녕하세요. 최지원입니다."
    }, {
        id: 2,
        message: "안녕하세요. 종강일은 12/12입니다"
    }, {
        id: 3,
        message: "11월은 쉬는 날이 없습니다."
    }
]

class CommentList extends Component {

    constructor(props) {
        super(props)

        this.state = {
            commentList: [],
        }
    }

    componentDidMount(){
       // const commetList = this.state.commentList
       //const data1 = this.state.data1
       //const data2 = this.state.data2

       //const { commetList, data1, data2 } = this.state; //비구조할당


    }

    render() {
        return (
            <div>
                {
                    this.state.commentList.map(c => {
                        return (
                            <Comment key={c.id}
                                     id={c.id}
                                     message={c.message}
                            />
                        )
                    })
                }
            </div>
        )
    }
}

export default CommentList
