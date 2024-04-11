import React, { ReactNode, useState } from 'react';
import Select, { SelectChangeEvent } from '@mui/material/Select';
import { Box, FormControl, FormHelperText, MenuItem, Table, TableBody, TableCell, TableContainer, TableHead, TableRow } from '@mui/material';
import axios from 'axios';
import { Item } from './types/item';

export enum Country{
  HY,KA,SL,RU,GE,BS,CS,DE,PL,BE,EN,HR,SR,UK
}

const App: React.FC = () => {
  const [lang, setLang] = React.useState('');

  const [sex, setSex] = React.useState('');
  const [outfit, setOutfit] = useState<Item[]>();
  function handleLangChange(event: SelectChangeEvent<any>, child: ReactNode): void {
    setLang(event.target.value);
  }
  function handleSexChange(event: SelectChangeEvent<any>, child: ReactNode): void {
    setSex(event.target.value);

    axios.get<Item[]>("http://localhost:8080/random/" + event.target.value).then((response) => {
      setOutfit(response.data);
      debugger
    },
      (error) => {
        const _content =
          (error.response &&
            error.response.data &&
            error.response.data.message) ||
          error.message ||
          error.toString();

        setOutfit(_content);
      }
    );
  }

  return (
    <div>
      <FormControl fullWidth>
        <Select
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          value={lang}
          label="Age"
          sx={{
            height: 40,
            width: 350,
            maxHeight: { xs: 233, md: 167 },
            maxWidth: { xs: 350, md: 250 },
          }}
          onChange={handleLangChange}
        >
          {
            Object.keys(Country).flatMap((value,index)=>{
              if(!isNaN(Number(value))){
                return;
              }
              return (<MenuItem value={value}>{value}</MenuItem>)

            })
          };


        </Select>
        <FormHelperText>Language</FormHelperText>

        <Select
          labelId="demo-simple-select-label"
          id="demo-simple-select"
          value={sex}
          label="Age"
          sx={{
            height: 40,
            width: 350,
            maxHeight: { xs: 233, md: 167 },
            maxWidth: { xs: 350, md: 250 },
          }}
          onChange={handleSexChange}
        >
          <MenuItem value="MALE">Male</MenuItem>
          <MenuItem value="FEMALE">Female</MenuItem>
        </Select>
        <FormHelperText>Sex</FormHelperText>

      </FormControl>
      <TableContainer>
        <Table sx={{ overflow: "auto" }} size="small" stickyHeader aria-label="sticky table">
          <TableHead>
            <TableRow>
              <TableCell>Bild</TableCell>
              <TableCell>description</TableCell>
              <TableCell>brand</TableCell>
              <TableCell>sex</TableCell>
              <TableCell>pantone_color_name</TableCell>
              <TableCell>current_price</TableCell>
              <TableCell>größen</TableCell>
            </TableRow>
          </TableHead>
          <TableBody>
            {outfit?.map((item) => (
              <TableRow>
                <TableCell><Box component="img" sx={{
                  height: 233,
                  width: 350,
                  maxHeight: { xs: 233, md: 167 },
                  maxWidth: { xs: 350, md: 250 },
                }} src={`https://api.newyorker.de/csp/images/image/public/${item.variants[0].images[0].key}`} />
                </TableCell>
                <TableCell>{item.descriptions.map((key) =>{
                  if(key.language === lang){
                    return (key.description);
                  }
                })}</TableCell>
                <TableCell>{item.brand}</TableCell>
                <TableCell>{item.customer_group}</TableCell>
                <TableCell>{item.variants[0].pantone_color_name}</TableCell>
                <TableCell>{item.variants[0].current_price}</TableCell>
                <TableCell>{item.variants[0].sizes.map((size) => (
                  size.size_name + ","
                ))}</TableCell>

              </TableRow>
            ))}
          </TableBody>
        </Table>
      </TableContainer>
    </div>
  )

}
export default App;