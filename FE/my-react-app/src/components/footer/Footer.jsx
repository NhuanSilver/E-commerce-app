import SearchOutlinedIcon from '@mui/icons-material/SearchOutlined';
import HomeOutlinedIcon from '@mui/icons-material/HomeOutlined';
import PersonOutlineOutlinedIcon from '@mui/icons-material/PersonOutlineOutlined';
export default function Footer() {
    return (
        <>
            <footer className="fixed bottom-0 z-50 p-6 flex justify-center w-full">
                <div className="flex justify-between items-center w-[500px] text-white">
                    <a href="#"><HomeOutlinedIcon /></a>
                    <a href="#"><SearchOutlinedIcon  sx={{ fontSize: 45 }}/></a>
                    <a href="#"><PersonOutlineOutlinedIcon/></a>
                </div>
            </footer>
    </>
    )
}