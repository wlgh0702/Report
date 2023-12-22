import header from '../CSS/header.module.css'
import {Link} from "react-router-dom";

const Header = () => {
    return (
        <div className={header.headerWrapper}>
            <div className={header.menu}>
                <Link to="/" className={header.pageName}>JourneyBites</Link>
                <Link to="/nation"className={header.international}>국가 별 여행</Link>
                <Link to="/season" className={header.season}>계절 별 여행</Link>
                <Link to="/more" className={header.board}>정보 추가 신청</Link>
            </div>
        </div>
    )
}

export default Header;