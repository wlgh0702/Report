import con from '../CSS/content.module.css'

const Content = () => {
    return (
        <div className={con.wrapper}>
            <div className={con.image}>
                <div className={con.midText}>여행에 관한 모든 정보</div>
            </div>
            <div className={con.bottom}>
                <div className={con.botText}>전 세계 맛집을 한눈에</div>
                <div className={con.botText}>추천 시기와 장소까지</div>
            </div>

        </div>
    )
}

export default Content;